/** @jsx React.DOM */
'use strict';
define([ 'underscore', 'react', 'constant/Constants', 'component/Dashboard',
         'component/Ingame', 'store/SettingStore', 'dispatcher/AppDispatcher', 
          ], function(
    _, React, Constants, Dashboard, Ingame, SettingStore, AppDispatcher) {

  var App = React.createClass({

    getInitialState: function(){
      var setting = SettingStore.getAll();
      return {
        setting: setting,
        show: 'Dashboard',
      };
    },
    
    componentWillMount: function(){
      window.App = this;
    },
    
    componentDidMount: function(){
      var self = this;
      SettingStore.addChangeListener(function(){
        self.setState({
          setting: SettingStore.getAll(),
        });
      });
      
      this.addressRouting();
    },
    
    addressRouting: function(){
      var self = this,
        actionToComponent = {
        }, 
        routeToComponent = {
          START_GAME: 'Ingame',
          END_GAME: 'Dashboard',
        };
      
      this.dispatcherIndex = AppDispatcher.register(function(action) {
        var component = action.actionType === Constants.ROUTE ? 
          routeToComponent[action.component] : 
          actionToComponent[action.actionType];
        component && self.setState({
          show: component,
        });
      });
    },
    
    getMainComponentByRoute: function(){
      var state = this.state,
        setting = state.setting;
      
      switch(state.show){
        case 'Ingame': return <Ingame setting={setting} />;
        case 'Dashboard': return <Dashboard setting={setting} />;
      };
    },
    
    render: function() {
      return (
        <div>
          {this.getMainComponentByRoute()}
        </div>
      );
    },
    
  });
  
  return App;
});