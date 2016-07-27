'use strict';

var rootPath = '..', appPath = rootPath + '/app';

requirejs.config({
  baseUrl : 'js/lib',

  paths : {
    app : appPath,
    model : appPath + '/model',
    collection : appPath + '/collection',
    view : appPath + '/view',
    mixin : appPath + '/mixin',
    sub : appPath + '/view/sub',
    util : appPath + '/util',
    react : 'react-with-addons',
    component : appPath + '/component',
    ingame : appPath + '/component/ingame',
    showRole : appPath + '/component/showRole',
    dashboard : appPath + '/component/dashboard',
    action : appPath + '/action',
    constant : appPath + '/constant',
    dispatcher : appPath + '/dispatcher',
    store : appPath + '/store',
    localstorage : 'backbone.localStorage',
    jquerymobile : 'jquery.mobile',
  },

  shim : {
    backbone : {
      deps : [
        'underscore',
        'jquery' ],
      exports : 'Backbone'
    },
    underscore : {
      exports : '_'
    },
    react : {
      exports : 'React'
    },
    localstorage : {
      deps : [ 'backbone' ]
    }
  },
});

function wlCommonInit() {

  requirejs([
    'jquery',
  ], function($) {
    $(document).on('mobileinit', function() {
      // Prevents all anchor click handling including the addition of
      // active
      // button state and alternate link bluring.
      $.mobile.linkBindingEnabled = false;

      // $.mobile.autoInitializePage = false;

      // Disabling this will prevent jQuery Mobile from handling hash
      // changes
      $.mobile.hashListeningEnabled = false;

      console.log("mobile init!");

      // disable selection for any element on the page
      $(document).on('selectstart', function() {
        return false;
      });

      // make sure scroll event fires sooner on ios
      // document.addEventListener("touchmove", function() {
      // $(window).trigger("scroll");
      // }, false);
      // document.addEventListener("scroll", function() {
      // $(window).trigger("scroll");
      // }, false);

      // set default page transition
      // $.mobile.defaultPageTransition =
      // Constants.DEFAULT_PAGE_TRANSITION;

      // $.mobile.page.prototype.options.domCache = true;

      // Instantiates a new Backbone.js Mobile Router
      // MobileRouter = new MobileRouter();
    });

    requirejs([
      'jquerymobile',
      'bootstrap',
      'util/AjaxUtil',
      'globalize',
      'underscore',
      'promise',
      'util/Lexicon' ], function($mobile, bootstrap, AjaxUtil, globalize, _, P,
      Lexicon) {

      var messagesFolder = 'js/localizations/messages/';
      var jsonSuffix = '.json';

      // Load culture and messages
      Globalize.initialize = function(culture) {
        return new Promise(function(resolve, reject) {
          // Load messages synchronously
          AjaxUtil.getJSON(messagesFolder + culture + jsonSuffix,
            function(data) {
              // Add messages and custom volume and currency format
              Globalize.addCultureInfo(culture, _.defaults({
                messages : data,
              }));

              // Select the culture
              Globalize.culture(culture);

              resolve();
            }, false);
        });
      };
      Promise.all([
        Globalize.initialize('zh-CN'),
        Lexicon.loadLexicon(),
      ]).then(
        function() {
          requirejs([
            'react',
            'component/App',
          ], function(React, App) {
            React.initializeTouchEvents(true);
            React.render(React.createElement(App, null), document
              .getElementById('app'));
          });
        });

    });
  });
}

window.WL ? WL.Client.init({
  connectOnStartup : false,
}) : wlCommonInit();
