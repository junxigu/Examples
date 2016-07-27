/** @jsx React.DOM */
'use strict';
define([
  'react',
  'action/Actions',
  'dashboard/RoleSetting',
], function(React, Actions, RoleSetting) {

  var localize = Globalize.localize.bind(Globalize);
  var ReactPropTypes = React.PropTypes;

  var RoleSettingList = React.createClass({

    propTypes : {
      roles : ReactPropTypes.object.isRequired,
    },

    render : function() {
      var roles = this.props.roles;

      return (
        <ul id='serviceEvents' data-role='listview' data-inset='false' data-theme='d'
          data-dividertheme='d'>
          <li data-role='list-divider'>{localize('RoleConfiguration.title')}</li>
          <RoleSetting opt={roles.common} count={20} min={2}
            roleName='common' onChange={this.changeRole}
            title={localize('RoleConfiguration.select.common')} />
          <RoleSetting opt={roles.undercover} count={10} 
            roleName='undercover' onChange={this.changeRole}
            title={localize('RoleConfiguration.select.undercover')} />
          <RoleSetting opt={roles.whiteBoard} min={0} count={5} 
            roleName='whiteBoard' onChange={this.changeRole}
            title={localize('RoleConfiguration.select.whiteBoard')} />
        </ul>
      );
    },

    validateRolesSetting : function(roles) {
      var common = roles.common;
      var undercover = roles.undercover;
      var whiteBoard = roles.whiteBoard;
      var valid = common > undercover && common > undercover + whiteBoard;

      if (!valid) {
        alert(localize('RoleConfiguration.alert'));
      }
      return valid;
    },

    changeRole : function(roleName, val) {
      var roles = _.clone(this.props.roles);
      roles[roleName] = val;

      if (this.validateRolesSetting(roles)) {
        Actions.changeRoles(roles);
        return true;
      }
      return false;
    },

  });

  return RoleSettingList;
});
