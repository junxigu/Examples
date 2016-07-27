/** @jsx React.DOM */
'use strict';
define([
  'underscore',
  'react',
  'action/Actions',
  'util/Lexicon',
  'constant/Constants',
  'component/Header',
  'ingame/IngamePlayerList',
  'util/GameController',
  'mixin/JQMMixin',
  'dispatcher/AppDispatcher',
], function(_, React, Actions, Lexicon, Constants, Header, IngamePlayerList,
  GameController, JQMMixin, AppDispatcher) {

  var localize = Globalize.localize.bind(Globalize);

  var ReactPropTypes = React.PropTypes;

  var Ingame = React.createClass({

    mixins : [ JQMMixin ],

    propTypes : {
      players : ReactPropTypes.array.isRequired,
    },

    render : function() {
      return (
        <div id='ingame' data-role='page'>
          <Header backButton={true} backButtonHandler={this.restart}
            homeButton={true} homeButtonHandler={this.setting} title='游戏中' />
          <div data-role='content' className='ui-content'>
            <IngamePlayerList players={this.props.players} killPlayerHandler=
              {this.killPlayer} />
          </div>
        </div>
      );
    },

    componentDidMount: function() {
      var start = Math.floor((Math.random() * this.props.players.length)) + 1;
      alert('从玩家' + start + '开始');
    },
    
    killPlayer: function(i) {
      var players = this.props.players;
      players[i].killed = true;
      if(GameController.isGameOver(players)){
        Actions.route(Constants.SHOW_ROLES);
      }
    },
    
    restart : function() {
      Actions.route(Constants.SHOW_ROLES, {
        animation: 'left',
      });
    },

    setting : function() {
      Actions.route(Constants.DASHBOARD, {
        animation: 'left',
      });
    },
  });

  return Ingame;
});
