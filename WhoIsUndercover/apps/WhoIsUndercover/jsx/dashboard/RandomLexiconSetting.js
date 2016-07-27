/** @jsx React.DOM */
'use strict';
define([
  'react',
  'dashboard/LexiconCheckbox',
  'util/Lexicon',
  'mixin/BackboneViewMixin',
  'action/Actions',
], function(React, LexiconCheckbox, Lexicon, BackboneViewMixin, Actions) {

  var ReactPropTypes = React.PropTypes;

  var RandomLexiconSetting = React.createClass({

    mixins: [BackboneViewMixin],
    
    propTypes : {
      selectedTypes : ReactPropTypes.array.isRequired,
    },

    render : function() {
      var i, type, content = [];
      var types = Lexicon.getTypes();

      for (i = 0; i < types.length; i++) {
        type = types[i];
        content.push(<LexiconCheckbox index={i} type={type} key={i}
          checked={this.props.selectedTypes.indexOf(type) >= 0} />);
      }
      
      return (
        <form>
          <fieldset data-role='controlgroup' data-type='horizontal'>
           {content}
          </fieldset>
        </form>
      );
    },
    
    events: {
      'change': 'onChange',
    },
    
    onChange : function(event) {
      Actions
        .toggleRandomType($(event.target).val(), $(event.target).prop('checked'));
    },
  });

  return RandomLexiconSetting;
});
