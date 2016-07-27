/** @jsx React.DOM */
'use strict';
define([
  'react',
  'component/RoleConfiguration',
  'action/Actions',
  'constant/Constants',
  'util/Lexicon',
  'component/LexiconConfiguration',
], function(React, RoleConfiguration, Actions, Constants, Lexicon,
  LexiconConfiguration) {

  var localize = Globalize.localize.bind(Globalize);

  var Dashboard = React.createClass({

    render : function() {
      var setting = this.props.setting
      var roles = setting.roles;
      
      return (
        <div id='setting'>
          <header>{localize('Dashboard.header')}</header>
          <RoleConfiguration roles={setting.roles} />
          <LexiconConfiguration lexiconSetting={setting.lexiconSetting} 
            types={Lexicon.getTypes()} />
          <input className='primaryButton' type='button' 
            value={localize('Dashboard.button.startGame')} 
            onClick={this.startGame} />
        </div>
      );
    },

    startGame : function() {
      Actions.route(Constants.START_GAME);
    },
  });

  return Dashboard;
});
