define(['underscore', ], function(_) {
  
  var localize = Globalize.localize.bind(Globalize);
  
  var defaultWinerHandlers = {
      common: function(){
        alert(localize('GameController.alert.common'));
      },
      undercover: function(){
        alert(localize('GameController.alert.undercover'));
      },
      whiteBoard: function(){
        alert(localize('GameController.alert.whiteBoard'));
      },
  };
  
  function countRole(players, properties){
    return _.where(players, properties).length;
  }
  
  function getRemainPlayers(players){
    return {
      common : countRole(players, {
        role: 'common',
        killed: false,
      }),
      undercover : countRole(players, {
        role: 'undercover',
        killed: false,
      }),
      whiteBoard : countRole(players, {
        role: 'whiteBoard',
        killed: false,
      }),
    };
  }
  
  function findWinder(remainPlayers, winerHandlers){
    var common = remainPlayers.common,
    undercover = remainPlayers.undercover,
    whiteBoard = remainPlayers.whiteBoard;
    
    if(common + undercover + whiteBoard === 2){
      if(undercover > 0){
        winerHandlers.undercover();
      } else if(whiteBoard > 0){
        winerHandlers.whiteBoard();
      } else{
        winerHandlers.common();
      }
      return true;
    } else if(undercover === 0 && whiteBoard === 0){
      winerHandlers.common();
      return true;
    }
    return false;
  }
  
  return {
    isGameOver: function(players, winerHandler){
      var remainPlayers = getRemainPlayers(players);
      if(remainPlayers < 2){
        throw 'Wrong Player Ammount';
      }
      return findWinder(remainPlayers, winerHandler || defaultWinerHandlers);
    },
  };

});