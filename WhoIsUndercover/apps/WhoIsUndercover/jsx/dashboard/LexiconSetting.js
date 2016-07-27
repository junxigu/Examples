/** @jsx React.DOM */
'use strict';
define([
  'react',
  'dashboard/RandomLexiconSetting',
  'dashboard/CustomizedLexiconSetting',
  'mixin/BackboneViewMixin',
  'action/Actions',
], function(React, RandomLexiconSetting, CustomizedLexiconSetting,
  BackboneViewMixin, Actions) {

  var ReactPropTypes = React.PropTypes;

  var LexiconSetting = React.createClass({

    mixins: [BackboneViewMixin],
    
    propTypes : {
      lexiconSetting : ReactPropTypes.object.isRequired,
    },

    getInitialState : function() {
      return this.props.lexiconSetting;
    },

    render : function() {
      var state = this.state;
      var isRandomLexicon = state.lexiconType === 'random';

      return (
        <div id='lexicon-setting' data-toggle='tab' role='tabpanel'>
          <ul className='nav nav-tabs' role='tablist'>
            <li role='presentation' className={isRandomLexicon ? 'active' : ''}>
              <a href='#random-lexicon' aria-controls='random-lexicon' role='tab' data-toggle='tab'>随机词库</a>
            </li>
            <li role='presentation' className={isRandomLexicon ? '' : 'active'}>
              <a href='#specified-lexicon' aria-controls='specified-lexicon' role='tab' data-toggle='tab'>定制词库</a>
            </li>
          </ul>
  
          <div className='tab-content'>
            <div role='tabpanel' className={'tab-pane ' + (isRandomLexicon ? 'active' : '')} id='random-lexicon'>
              <RandomLexiconSetting selectedTypes={state.selectedTypes} />
            </div>
            <div role='tabpanel' className={'tab-pane ' + (isRandomLexicon ? '' : 'active')} id='specified-lexicon'>
              <CustomizedLexiconSetting specifiedWords={state.specifiedWords} />
            </div>
          </div>
        </div>
      );
    },
    
    componentDidMount : function() {
      this.view.$('a[data-toggle="tab"]').on('show.bs.tab', function(event) {
        Actions.toggleLexiconType($(event.target).attr('aria-controls') 
          === 'random-lexicon'
          ? 'random' : 'specified');
      });
    },
    
  });

  return LexiconSetting;
});
