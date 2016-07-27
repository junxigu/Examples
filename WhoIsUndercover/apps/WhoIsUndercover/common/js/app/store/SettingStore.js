define([ 'underscore', 'backbone', 'localstorage', 'dispatcher/AppDispatcher',
     ], function(_, Backbone, localstorage,
    AppDispatcher) {

  var CHANGE_EVENT = 'all';

  var Setting = Backbone.Model.extend({

    defaults : {
      roles: {
        common: 2,
        undercover: 1,
        whiteBoard: 0,
      },
      lexiconSetting: {
        lexiconType: 'random',
        selectedTypes: [],
        specifiedWords: [],
      },
    },

  });

  var Settings = Backbone.Collection.extend({
    localStorage : new Backbone.LocalStorage('Settings'),
    model : Setting,
  });
  var settings = new Settings();
  settings.fetch();
  var setting = settings.at(0) || settings.create();

  var SettingStore = {

    actions : {
      CHANGE_ROLES : function(action) {
        var roles = action.roles;
        typeof roles !== 'undefined' && setting.save({
          roles : roles,
        });
      },
      
      CHANGE_LEXICON_SETTING : function(action) {
        SettingStore.saveLexiconSetting(action.lexiconSetting);
      },
      
      TOGGLE_RANDOM_LEXICON_TYPE : function(action) {
        var lexiconSetting = setting.get('lexiconSetting');
        var selectedTypes = lexiconSetting.selectedTypes;
        var type = action.type;
        var i = selectedTypes.indexOf(type);
        
        if(action.checked){
          i < 0 && selectedTypes.push(type);
        } else {
          i >= 0 && selectedTypes.splice(i, 1);
        }
        SettingStore.saveLexiconSetting(lexiconSetting);
      },
      
      CHANGE_SPECIFIED_LEXICON_TYPE : function(action) {
        var lexiconSetting = setting.get('lexiconSetting');
        lexiconSetting.specifiedWords[action.i] = action.type;
        SettingStore.saveLexiconSetting(lexiconSetting);
      },
      
      TOGGLE_LEXICON_TYPE : function(action) {
        var lexiconSetting = setting.get('lexiconSetting');
        lexiconSetting.lexiconType = action.type;
        SettingStore.saveLexiconSetting(lexiconSetting);
      },
      
    },

    saveLexiconSetting: function(lexiconSetting) {
      setting.save({
        lexiconSetting : lexiconSetting,
      });
    },
    
    getAll : function() {
      return setting.toJSON();
    },

    getRoles: function(){
      return setting.get('roles');
    },
    
    isSet: function(){
      var roles = setting.get('roles');
      return roles.common > roles.undercover;
    },

    addChangeListener : function(callback) {
      setting.on(CHANGE_EVENT, callback);
    },

    removeChangeListener : function(callback) {
      setting.off(CHANGE_EVENT, callback);
    },

    dispatcherIndex : AppDispatcher.register(function(action) {
      var handler = SettingStore.actions[action.actionType];
      handler && handler(action);
    }),

  };

  return SettingStore;
});
