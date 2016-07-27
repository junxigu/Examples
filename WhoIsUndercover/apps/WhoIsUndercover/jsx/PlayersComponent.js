/** @jsx React.DOM */
'use strict';
define(['underscore', 'react', 'component/Player', ], 
        function( _, React, Player){
  
  var ReactPropTypes = React.PropTypes;
  
  var PlayersComponent = React.createClass({

    propTypes: {
      players: ReactPropTypes.array.isRequired,
      started: ReactPropTypes.bool.isRequired,
    },
    
    render: function() {
      var playerComponents = [],
        props = this.props,
        players = props.players;

      for(var i = 0, len = players.length; i < len; i++){
        playerComponents.push(<Player player={players[i]} index={i}
          key={i} started={props.started} />);
      }
    
      return (
        <div id='players'>
          {playerComponents}
        </div>
      );
    },
    
  });
  
  return PlayersComponent;
});
  
