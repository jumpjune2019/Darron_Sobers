var Controller = (function() {

	var addButtonClickEvent = function(textTrigger, event) {
		var model = this;
		var value = textTrigger.value.trim();
		
		if(value.length) {
			if(model.notDuplicate(value)) {
				model.Add(value);
				textTrigger.value = null;
			} else {
				alert("Duplicate Value");
			}
		};
	
	}

	// DS 6/27/2019
	// when the enter key is used to insert data this object is called
	var addEnterKeyEvent = function(textTrigger, event) {
		// DS 6/27/2019
		// reused the addButtonClickEvent object as a template
		var model = this;
		var value = textTrigger.value.trim();

		// DS 6/27/2019
		// when .which and .keycode return the Unicode character value
		// of the button pressed and assigns it to the key variable
		// https://www.w3schools.com/jsref/event_key_keycode.asp
		var key = event.which || event.keyCode;
		// DS 6/27/2019
		// the unicode character key is 13 which is the enter key then
		// the condition is true
		if(key === 13) {
			if(value.length) {
				if(model.notDuplicate(value)) {
					model.Add(value);
					textTrigger.value = null;
				} else {
					alert("Duplicate Value");
				}
			};
		}// End of DS if
	}


	var deleteButtonClickEvent = function(event) {
		var model = this;
		if(event.target.type == "button") {
			model.Delete(event.target.value);
		
		}
	
	}

	var constructor = function() {

		var scopeEl;
		var model;
		var view;

		this.init = function(el, m, v) {
			scopeEl = el;
			model = m;
			view = v;
			model.setScope(el);
			model.setView(view);
			model.registerWidget(view.listView());
			model.registerWidget(view.summaryView());
			model.refreshWidgets(view, model);
			
			
			var addButton = view.triggerField().getButtonInstance(el);
			var textTrigger = view.triggerField().getTextInstance(el);
			// DS 6/27/2019
			// created an object that is linked to the Add button 
			var enterTrigger = view.triggerField().getTextInstance(el);
			
			addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));
			// DS 6/27/2019
			// when input is submitted by a key the addEnterKeyEvent() method is executed
			// https://www.w3schools.com/jsref/event_onkeypress.asp 
			enterTrigger.addEventListener("keypress", addEnterKeyEvent.bind(model, textTrigger));
			var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
			listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));
			
		};
		
	};
	
	return new constructor();
	
});