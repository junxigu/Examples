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

        deleteToken : function() {
          this.token.destroy({
            success: function(model) {
              this.$el.remove();
            }.bind(this),
          });
        },

        updateToken : function() {
          ViewUtils.collectInfoToToken(this.$('input'), this.token);
          this.token.save();
        },
      });

    });