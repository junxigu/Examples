/** @jsx React.DOM */
'use strict';
define([
  'react',
  'slick',
  'action/Actions',
  'component/Header',
  'mixin/JQMMixin',
  'mixin/BackboneViewMixin',
  'util/Lexicon',
  'constant/Constants',
], function(React, Slick, Actions, Header, JQMMixin, BackboneViewMixin,
  Lexicon, Constants) {

  function getWords(lexiconSetting) {
    return lexiconSetting.lexiconType === 'random' ? Lexicon
      .getRandomWords(lexiconSetting.selectedTypes)
      : lexiconSetting.specifiedWords;
  }

  function fillArray(count, val, arr) {
    arr = arr || [];
    for (var i = 0; i < count; i++) {
      arr.push(val);
    }
    return arr;
  }

  function generateRoleArray(roles) {
    var roleArray = fillArray(roles.whiteBoard, 'whiteBoard');
    fillArray(roles.undercover, 'undercover', roleArray);
    fillArray(roles.common, 'common', roleArray);
    return _.shuffle(roleArray);
  }

  function generatePlayers(roleArray, wordPair) {
    var players = [], role, word;

    for (var i = 0, len = roleArray.length; i < len; i++) {
      role = roleArray[i];
      word = role === 'whiteBoard' ? '' : (wordPair[role === 'common' ? 0 : 1] 
        || '');
      players.push({
        role : role,
        word : word,
        killed : false,
        checked : false,
      });
    }
    return players;
  }

  var localize = Globalize.localize.bind(Globalize);

  var ReactPropTypes = React.PropTypes;

  var ShowRole = React.createClass({

    mixins : [
      JQMMixin,
      BackboneViewMixin ],

    propTypes : {
      setting : ReactPropTypes.object.isRequired,
    },

    getInitialState : function() {
      var setting = this.props.setting;
      return {
        players : generatePlayers(generateRoleArray(setting.roles),
          getWords(setting.lexiconSetting)),
        checkingPlayerIndex : 1,
      };
    },

    render : function() {
      var setting = this.props.setting;
      var state = this.state;
      var players = state.players;

      return (
        <div id='showRole' data-role='page'>
          <Header backButton={true} backButtonHandler={this.restart}
            title='查看角色' />
          <div data-role='content' className='ui-content'>
            <p id='player'>玩家 {state.checkingPlayerIndex}</p>
            
            <div id='showRoleIcon' >
              <span className='glyphicon glyphicon-eye-open' aria-hidden='true'></span>
              <p>点击查看角色</p>
            </div>
          </div>
        </div>
      );
    },

    events : {
      'touchend #showRoleIcon' : 'checkPlayer',
    },

    checkPlayer : function() {
      var state = this.state;
      var players = state.players;
      var checkingPlayerIndex = state.checkingPlayerIndex;

      alert(players[checkingPlayerIndex - 1].word);

      if (checkingPlayerIndex === players.length) {
        Actions.route(Constants.START_GAME, {
          componentArgs: players,
        });
      } else {
        this.setState({
          checkingPlayerIndex : checkingPlayerIndex + 1,
        });
      }
    },

    restart : function() {
      Actions.route(Constants.DASHBOARD, {
        animation: 'left',
      });
    },
  });

  return ShowRole;
});
