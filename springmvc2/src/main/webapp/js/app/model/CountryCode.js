define([ 'backbone', ], function(Backbone) {

  return Backbone.Model.extend({

    urlRoot : "rest/countryCodes",

    defaults : {
      regionCode : '',
      countryCode : '',
      countryDescription : '',
      crncyDescription : '',
      creationTime : '',
    },

  });

});