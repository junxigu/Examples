/** @jsx React.DOM */
'use strict';
define([
  'react',
  'action/Actions',
  'ingame/GameInstruction',
  'ingame/IngamePlayer',
], function(React, Actions, GameInstruction, IngamePlayer) {

  var localize = Globalize.localize.bind(Globalize);

  var ReactPropTypes = React.PropTypes;

  var IngamePlayerList = React.createClass({

    propTypes : {
      players : ReactPropTypes.array.isRequired,
      killPlayerHandler : ReactPropTypes.func.isRequired,
    },

    render : function() {
      var self = this;
      var playerList = this.props.players.map(function(player, i){
        return <IngamePlayer player={player} index={i} key={i}
          killPlayerHandler={self.killPlayer} />;
      });

      
      return (
        <ul id='serviceEvents' data-role='listview' data-inset='false' 
          data-theme='d' data-divider-theme='a'>
          <GameInstruction />
          {playerList}
        </ul>
      );
    },

    killPlayer : function(index) {
      this.props.killPlayerHandler(index);
    },

  });

  return IngamePlayerList;
});
