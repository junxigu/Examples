define([ 'backbone', 'util/AjaxUtils', ], function(Backbone, AjaxUtils) {

  return Backbone.Model.extend({

    urlRoot : "rest/merchantServices",

    defaults : {
      serviceMerchantId : 0,
      countryCode : 0,
      alias : '',
      password : '',
      partnerId : '',
      systemId : '',
      certificate : '',
      description : '',
      creationTime : '',
      updateTime : '',
    },

  });

});