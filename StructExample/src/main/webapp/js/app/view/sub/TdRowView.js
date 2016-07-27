define([ 'backbone', 'model/ServiceMerchantToken', 'util/ViewUtils', ],
    function(Backbone, ServiceMerchantToken, ViewUtils) {

      return Backbone.View.extend({

        events : {
          'click .delete' : 'deleteToken',
          'click .update' : 'updateToken',
        },

        initialize : function(token) {
          this.token = token;
          return this;
        },

        render : function() {
          var template = _.template($('#table-body-row').html());
          var $el = $('<tr>').append(template(this.token.toJSON()));
          return this.setElement($el);
        },

        createRequstToken : function() {
          var rawModel = {};
          var json = this.token.toJSON();
          for ( var key in json) {
            rawModel['merchantToken.' + key] = json[key];
          }
          return new ServiceMerchantToken(rawModel);
        },

        deleteToken : function() {
          var self = this;
          this.createRequstToken()['delete'](function(data) {
            self.$el.remove();
            self.trigger('removeToken', data);
          });
        },

        updateToken : function() {
          var self = this;
          var requestToken = this.createRequstToken();
          ViewUtils.collectInfoToToken(this.$('input'), requestToken);
          requestToken.update(function(data) {
            self.trigger('updateToken');
          });
        },
      });

    });