define([ 'react', 'dispatcher/AppDispatcher', 'constant/Constants', ],
    function(React, AppDispatcher, Constants) {

  var Actions = {

    // News
    toggleRandomType : function(type, checked) {
      AppDispatcher.dispatch({
        actionType : Constants.TOGGLE_RANDOM_LEXICON_TYPE,
        type: type,
        checked: checked,
      });
    },
    
    changeSpecifiedType : function(i, type) {
      AppDispatcher.dispatch({
        actionType : Constants.CHANGE_SPECIFIED_LEXICON_TYPE,
        i: i,
        type: type,
      });
    },
    
    toggleLexiconType : function(type) {
      AppDispatcher.dispatch({
        actionType : Constants.TOGGLE_LEXICON_TYPE,
        type: type,
      });
    },
    
    // Olds
    changeRoles : function(roles) {
      AppDispatcher.dispatch({
        actionType : Constants.CHANGE_ROLES,
        roles : roles
      });
    },
    
    changeLexiconSetting : function(lexiconSetting) {
      AppDispatcher.dispatch({
        actionType : Constants.CHANGE_LEXICON_SETTING,
        lexiconSetting : lexiconSetting
      });
    },

    route : function(component, args) {
      AppDispatcher.dispatch({
        actionType : Constants.ROUTE,
        component: component,
        args: args,
      });
    },
    
    killPlayer: function(index){
      AppDispatcher.dispatch({
        actionType : Constants.KILL_PLAYER,
        index: index
      });
    },
    
  };

  return Actions;

});
