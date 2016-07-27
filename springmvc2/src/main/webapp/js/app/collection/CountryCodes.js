define([ 'backbone', 'model/CountryCode', ], function(Backbone, CountryCode) {

  var CountryCodes = Backbone.Collection.extend({

    url : "rest/countryCodes",
    
    model : CountryCode,

  });

  return CountryCodes;
});