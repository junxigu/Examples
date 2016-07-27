/** @jsx React.DOM */
'use strict';
define(['underscore', 'react', 'action/Actions', 'util/Lexicon',
        'dispatcher/AppDispatcher', 'constant/Constants',
        'component/PlayersComponent', 'util/GameController', ], 
        function( _, React, Actions, Lexicon, AppDispatcher, Constants,
            PlayersComponent, GameController){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var ReactPropTypes = React.PropTypes;
  
  var generateArray = function(len, val){
    var arr = [];
    for(var i = 0; i < len; i++){
      arr.push(val);
    }
    return arr;
  };
  
  // return an array, 
  // value: 0(role: common), 1(role: undercover), 2(role: whiteBoard)
  function generateRoleArray(roles){
    var roleArray = generateArray(roles.whiteBoard, 2).concat(
        generateArray(roles.undercover, 1)).concat(generateArray(roles.common
            , 0));
    return _.shuffle(roleArray);
  }
  
  function generatePlayers(roleArray, wordPair){
    var players = [], roleNum;
    
    for(var i = 0, len = roleArray.length; i < len; i++){
      roleNum = roleArray[i];
      players.push({
        role: roleNum,
        word: wordPair[roleNum] || '',
        killed: false,
      });
    }
    return players;
  }
  
  function getWords(lexiconSetting){
    return lexiconSetting.lexiconType === 'random' ? Lexicon.getRandomWords(
        lexiconSetting.selectedTypes) : lexiconSetting.specifiedWords;
  }
  
  var Ingame = React.createClass({

    propTypes: {
      setting: ReactPropTypes.object.isRequired,
    },
    
    getInitialState: function(){
      var props = this.props,
        setting = props.setting,
        roles = setting.roles;
      
      return {
        started: false,
        players: generatePlayers(generateRoleArray(roles),
            getWords(setting.lexiconSetting)),
      };
    },
    
    render: function() {
      var state = this.state,
        started = state.started;
      
      return (
        <div id='inGame'>
          <header>{localize('Ingame.header')}</header>
          <PlayersComponent players={state.players} started={started} />
          <div id='buttons'>
            <input className={started ? 'secondaryButton' : 'primaryButton'} 
              type='button' value={localize('Ingame.button.start')} 
              onClick={this.start} />
            <input className={started ? 'primaryButton' : 'secondaryButton'}
              type='button' value={localize('Ingame.button.restart')}
              onClick={this.restart} />
            <input className={started ? 'primaryButton' : 'secondaryButton'}
              type='button' value={localize('Ingame.button.setting')} 
              onClick={this.setting} />
          </div>
        </div>
      );
    },
    
    componentDidMount: function(){
      var players = this.state.players,
        actions = {
          KILL_PLAYER: function(action){
            players[action.index].killed = true;
            if(GameController.isGameOver(players)){
              setTimeout(function(){
                Actions.route(Constants.END_GAME);
              }, 0);
            }
          },
        };
      
      this.dispatcherIndex = AppDispatcher.register(function(action) {
        var handler = actions[action.actionType];
        handler && handler(action);
      });
    },
    
    componentWillUnmount: function(){
      AppDispatcher.unregister(this.dispatcherIndex);
    },
    
    restart: function(){
      this.setState(this.getInitialState());
    },
    
    start: function(){
      this.setState({
        started: true,
      });
    },
    
    setting: function(){
      Actions.route(Constants.END_GAME);
    },
  });
  
  return Ingame;
});
  
