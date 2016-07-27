requirejs.config({
  baseUrl : 'js/lib',

  paths : {
    app : '../app',
    model : '../app/model',
    collection : '../app/collection',
    view : '../app/view',
    sub : '../app/view/sub',
    util : '../app/util',
    root : '../',
  },
});

requirejs([ 'underscore', 'app/view/SerMrchntTkn' ], function(_, SerMrchntTkn) {

  _.templateSettings = {
    interpolate : /\{\{(.+?)\}\}/g
  };

  new SerMrchntTkn().render();
})