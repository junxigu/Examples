/** @jsx React.DOM */
'use strict';
define([
  'underscore',
  'react',
  'constant/Constants',
  'dashboard/Dashboard',
  'ingame/Ingame',
  'showRole/ShowRole',
  'store/SettingStore',
  'dispatcher/AppDispatcher',
], function(_, React, Constants, Dashboard, Ingame, ShowRole, SettingStore,
  AppDispatcher) {

  var ReactCSSTransitionGroup = React.addons.CSSTransitionGroup;
  
  var App = React.createClass({

    getInitialState : function() {
      var setting = SettingStore.getAll();
      return {
        setting : setting,
        show : 'Dashboard',
      };
    },

    componentWillMount : function() {
      window.App = this;
    },

    componentDidMount : function() {
      var self = this;
      SettingStore.addChangeListener(function() {
        self.setState({
          setting : SettingStore.getAll(),
        });
      });

      this.addressRouting();
    },

    addressRouting : function() {
      var self = this, actionToComponent = {}, routeToComponent = {
        START_GAME : 'Ingame',
        DASHBOARD : 'Dashboard',
        SHOW_ROLES : 'ShowRole',
      };

      this.dispatcherIndex = AppDispatcher.register(function(action) {
        var component = action.actionType === Constants.ROUTE
          ? routeToComponent[action.component]
          : actionToComponent[action.actionType];
        var args =  action.args;
        self.animation = 'right';
        if(component) {
          if(args) {
            self.componentArgs = args.componentArgs;
            self.animation = args.animation || 'right';
          }
          self.setState({
            show : component,
          });
        }
      });
    },

    getMainComponentByRoute : function() {
      var state = this.state, setting = state.setting;

      switch (state.show) {
       case 'Ingame': return <Ingame key='Ingame' players={this.componentArgs} />;
       case 'Dashboard': return <Dashboard key='Dashboard' setting={setting} />;
       case 'ShowRole': return <ShowRole key='ShowRole' setting={setting} />;
      };
    },

    animation: 'right',
    
    render : function() {
     return (
       <div>
         <ReactCSSTransitionGroup transitionName={this.animation}>
           {this.getMainComponentByRoute()}
         </ReactCSSTransitionGroup>
       </div>
     );
    },

  });

  return App;
});