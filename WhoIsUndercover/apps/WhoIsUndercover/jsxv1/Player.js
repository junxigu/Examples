/** @jsx React.DOM */
'use strict';
define(['react', 'action/Actions', 'dispatcher/AppDispatcher', ], 
        function( React, Actions, AppDispatcher){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var ReactPropTypes = React.PropTypes;
  
  var Player = React.createClass({

    propTypes: {
      //{word, killed, index, }
      player: ReactPropTypes.object.isRequired,
      started: ReactPropTypes.bool.isRequired,
      index: ReactPropTypes.number.isRequired,
    },
    
    getInitialState: function(){
      return {
        checked: false,
      };
    },
    
    componentWillReceiveProps: function(nextProps){
      if(!nextProps.started){
        this.setState({
          checked: false,
        });
      }
    },
    
    render: function() {
      var props = this.props,
        player = props.player,
        state = this.state,
        content = [],
        wordLable = localize(state.checked ? 'Player.button.wordAgain' :
          'Player.button.word');
      
      content.push(<span>{localize('Player.prefix')} {props.index + 1}</span>);
      if(!player.killed){
        content.push(<input type='button' onClick={this.checkWord}
          value={wordLable} />);
        content.push(<input className='killBtn' type='button' 
          value={localize('Player.button.kill')} 
          onClick={props.started ? this.killPlayer : function(){}} 
          disabled={!props.started} />);
      }
      
      return (
        <div>
          {content}
        </div>
      );
    },
    
    checkWord: function(){
      alert(this.props.player.word);
      this.setState({
        checked: true,
      });
    },
    
    killPlayer: function(event){
      this.setState({
        killed: confirm(localize('Player.confirm')),
      });
      Actions.killPlayer(this.props.index);
    },
    
  });
  
  return Player;
});
  
