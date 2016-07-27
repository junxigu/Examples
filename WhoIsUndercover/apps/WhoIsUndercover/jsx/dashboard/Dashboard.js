/** @jsx React.DOM */
'use strict';
define([
  'react',
  'component/RoleConfiguration',
  'action/Actions',
  'constant/Constants',
  'util/Lexicon',
  'component/Header',
  'dashboard/RoleSettingList',
  'dashboard/LexiconSetting',
  'mixin/JQMMixin',
], function(React, RoleConfiguration, Actions, Constants, Lexicon, Header,
  RoleSettingList, LexiconSetting, JQMMixin) {

  var localize = Globalize.localize.bind(Globalize);

  var ReactPropTypes = React.PropTypes;

  var Dashboard = React.createClass({

    mixins: [JQMMixin],
    
    propTypes : {
      setting : ReactPropTypes.object.isRequired,
    },

    render : function() {
      var setting = this.props.setting, roles = setting.roles;

      return (
        <div id='dashboard' data-role='page' data-theme='a'>
          <Header title={localize('Dashboard.header')} />
          <div data-role='content'>
            <RoleSettingList roles={setting.roles} />
            <LexiconSetting lexiconSetting={setting.lexiconSetting} />
            <div className='row buttonRow bottom'>
              <button data-role='button' data-theme='b' onTouchEnd={this.start}>
                {localize('Dashboard.button.startGame')}</button>
            </div>
          </div>
        </div>
      );
    },
    
    start: function() {
      var lexiconSetting = this.props.setting.lexiconSetting;
      var specifiedWords = lexiconSetting.specifiedWords;
      if(lexiconSetting.lexiconType === 'specified' && 
        /\s*/.test(specifiedWords[0]) && /\s*/.test(specifiedWords[1])){
        alert('请补全自定义词汇');
      } else {
        Actions.route(Constants.SHOW_ROLES);
      }
    },

  });

  return Dashboard;
});
