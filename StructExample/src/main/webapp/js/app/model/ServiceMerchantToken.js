define([ 'backbone', 'util/AjaxUtils', ], function(Backbone, AjaxUtils) {

  return Backbone.Model.extend({

    attrPrefix: 'merchantToken.',
    
    preUrlRoot : '/speedpasselement/serviceMerchantTokens',

    insertUrl : '/insert',
    updateUrl : '/update',
    deleteUrl : '/delete',

    defaults : {
      id : 0,
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

    connect : function(suffix, handleTokenData) {
      for(key in this.defaults){
        this.unset(key);
      }
      $.post(this.preUrlRoot + suffix, this.attributes, AjaxUtils
          .getCommonRequestHandler(handleTokenData));
      return this;
    },

    insert : function(handleTokenData) {
      this.connect(this.insertUrl, handleTokenData);
    },

    update : function(handleTokenData) {
      this.connect(this.updateUrl, handleTokenData);
    },

    'delete' : function(handleTokenData) {
      this.connect(this.deleteUrl, handleTokenData);
    },
  });

});