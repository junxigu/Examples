/** @jsx React.DOM */
'use strict';
define(['underscore', 'react', 'component/Select', 'component/Header', 
        'store/SettingStore', 'action/Actions', ], 
        function(_, React, Select, Header, SettingStore, Actions){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var ReactPropTypes = React.PropTypes;
  
  var RoleConfiguration = React.createClass({

    propTypes: {
      roles: ReactPropTypes.object.isRequired,
    },
    
    render: function() {
      var props = this.props,
        roles = this.props.roles;
      
      // Return setting page
      return (
        <form id='roleSettings' onChange={this.changeRoles}>
          <div>{localize('RoleConfiguration.title')}</div>
          <Select opt={roles.common} count={20} min={2} 
            title={localize('RoleConfiguration.select.common')} />
          <Select opt={roles.undercover} count={10} 
            title={localize('RoleConfiguration.select.undercover')} />
          <Select opt={roles.whiteBoard} min={0} count={5} 
            title={localize('RoleConfiguration.select.whiteBoard')} />
        </form>
      );
    },
    
    getNewRoles: function(){
      var settings = document.querySelectorAll('#roleSettings select');
      
      return [].map.call(settings, function(setting) {
        return parseInt(setting.value);
      });
    },
    
    validateRolesSetting: function(roles){
      var common = roles[0],
        undercover = roles[1],
        whiteBoard = roles[2],
        valid = common > undercover && common > undercover + whiteBoard;
      if(!valid){
        alert(localize('RoleConfiguration.alert'));
      }
      return valid;
    },
    
    changeRoles: function(){
      var roles = this.getNewRoles();
      if(roles && this.validateRolesSetting(roles)){
        Actions.changeRoles({
          common: roles[0],
          undercover: roles[1],
          whiteBoard: roles[2],
        });
      }
    },

  });
  
  return RoleConfiguration;
});

