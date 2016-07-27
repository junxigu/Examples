/** @jsx React.DOM */
'use strict';
define(['underscore', 'react', 'component/Select', 'component/Header', 
        'store/SettingStore', 'action/Actions', ], 
        function(_, React, Select, Header, SettingStore, Actions){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var ReactPropTypes = React.PropTypes;
  
  var LexiconConfiguration = React.createClass({

    propTypes: {
      lexiconSetting: ReactPropTypes.object.isRequired,
      types: ReactPropTypes.array.isRequired,
    },
    
    getInitialState: function(){
      return this.props.lexiconSetting;
    },
    
    getRandomTypeCheckbox: function(types, selectedTypes){
      var i, len, type, 
        checkboxs = [];
      
      for(i = 0, len = types.length; i < len; i++){
        type = types[i];
        checkboxs.push(
          <span>
            <label htmlFor={'type' + i}>{type}</label>
            <input type='checkbox' id={'type' + i} value={type} name='randomType' 
              checked={selectedTypes.indexOf(type) >= 0} />
          </span>
        );
//        checkboxs.push(
//        );
      }
      return (
        <form className='randomLexiconTypes' onChange={this.changeRandomType}>
          {checkboxs}
        </form>
      );
    },
    
    getSpecifiedTypeInputs: function(specifiedWords){
      return (
        <form className='specified' onChange={this.changeSpecifiedWords}>
          <div>
            <label htmlFor='common'>
              {localize('LexiconConfiguration.input.specifiedCommon')}</label>
            <input id='common' name='specifiedType' 
              value={specifiedWords[0]} />
          </div>
          <div>
            <label htmlFor='food'>
              {localize('LexiconConfiguration.input.specifiedUndercover')}</label>
            <input id='undercover' name='specifiedType' 
              value={specifiedWords[1]} />
          </div>
        </form>
      );
    },
    
    render: function() {
      var state = this.state, 
        isRandomLexicon = state.lexiconType === 'random',
        components;
      
      if(isRandomLexicon){
        components = this.getRandomTypeCheckbox(this.props.types, 
            state.selectedTypes);
      } else{
        components = this.getSpecifiedTypeInputs(state.specifiedWords);
      }
      
      return (
        <div id='LexiconConfiguration'>
          <div>{localize('LexiconConfiguration.title')}</div>
          <form className='lexiconType' onChange={this.changeLexiconType}>
            <div>
              <label htmlFor='random'>
                {localize('LexiconConfiguration.radio.random')}</label>
              <input type='radio' id='random' value='random' name='lexiconSetting'
                checked={isRandomLexicon} />
            </div>
            <div>
              <label htmlFor='specified'>
                {localize('LexiconConfiguration.radio.specified')}</label>
              <input type='radio' id='specified' value='specified' 
                name='lexiconSetting' checked={!isRandomLexicon} />
            </div>
          </form>
          {components}
        </div>
      );
    },
    
    changeLexiconType: function(event){
      this.setState({
        lexiconType: event.target.value,
      });
      this.changeLexiconSetting();
    },
    
    changeSpecifiedWords: function(event){
      var specifiedWords = this.state.specifiedWords;
      var target = event.target;
      specifiedWords[target.id === 'common' ? 0 : 1] = target.value;
      this.setState({
        specifiedWords: specifiedWords,
      });
      this.changeLexiconSetting();
    },
    
    changeRandomType: function(event){
      var types = event.currentTarget.querySelectorAll('input'),
        selectedTypes = [], i, len;
      
      for(i = 0, len = types.length; i < len; i++){
        types[i].checked && selectedTypes.push(types[i].value);
      }
      
      this.setState({
        selectedTypes: selectedTypes
      });
      this.changeLexiconSetting();
    },
    
    changeLexiconSetting: function(){
      var self = this;
      setTimeout(function(){
        Actions.changeLexiconSetting(self.state);
      }, 0);
    },
  });
  
  return LexiconConfiguration;
});

