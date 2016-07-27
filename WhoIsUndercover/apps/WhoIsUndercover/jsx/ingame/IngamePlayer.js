/** @jsx React.DOM */
'use strict';
define(['react', 'action/Actions', ], 
        function( React, Actions){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var ReactPropTypes = React.PropTypes;
  
  var IngamePlayer = React.createClass({

    propTypes: {
      //{role, word, killed, }
      player: ReactPropTypes.object.isRequired,
      killPlayerHandler: ReactPropTypes.func.isRequired,
      index: ReactPropTypes.number.isRequired,
    },
    
    getInitialState: function(){
      return this.props.player;
    },
    
    render: function() {
      var player = this.state, role = player.role, roleSpan, checkSpan, killSpan;
      
      if(player.killed) {
        roleSpan = role === 'common' ? <span className="role">平</span> :
          role === 'whiteBoard' ? <span className="role undercover">白</span> :
            <span className="role undercover">卧</span>;
      } else {
        checkSpan = <span className="glyphicon glyphicon-eye-open" aria-hidden="true"
          onTouchEnd={this.checkWord}></span>;
        killSpan = <span className="glyphicon glyphicon-remove" aria-hidden="true"
          onTouchEnd={this.killPlayer}></span>;
      }
      return (
        <li>
          {checkSpan}
          <span className="player">玩家 {this.props.index + 1}</span>
          {roleSpan}
          {killSpan}
        </li>
      );
    },
    
    checkWord: function(){
      alert(this.state.word);
    },
    
    killPlayer: function(){
      var props = this.props;
      this.setState({
        killed: confirm(localize('Player.confirm')),
      });
      props.killPlayerHandler(props.index);
    },
    
  });
  
  return IngamePlayer;
});
  
