package gwt.material.design.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.custom.ComplexWidget;
import gwt.material.design.client.custom.CustomInput;
import gwt.material.design.client.custom.CustomLabel;
import gwt.material.design.client.custom.CustomSpan;
import gwt.material.design.client.custom.HasError;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.client.custom.mixin.ErrorMixin;

//@formatter:off
/**
* Material Switch or other call it toggle - used for an alternative for checkbox
*
* <h3>UiBinder Usage:</h3>
* <pre>
*{@code<m:MaterialSwitch value="true"/>
* <m:MaterialSwitch value="true" disabled="true"/>
* }
* </pre>
 *
* @author kevzlou7979
* @see <a href="http://gwt-material-demo.herokuapp.com/#forms">Material Switch</a>
*/
//@formatter:on
public class MaterialSwitch extends ComplexWidget implements HasValue<Boolean>, HasClickHandlers, HasError {

	private CustomInput input = new CustomInput();
	private CustomSpan span = new CustomSpan();
	private CustomLabel label = new CustomLabel();
	private MaterialLabel lblError = new MaterialLabel();

	private final ErrorMixin<MaterialSwitch, MaterialLabel> errorMixin = new ErrorMixin<>(this, lblError, null);

	/**
	 * Creates a switch element
	 */
	public MaterialSwitch() {
		super(Document.get().createDivElement());
		setStyleName("switch");
		span.setStyleName("lever");
		input.setType(InputType.CHECKBOX);
		label.add(input);
		label.add(span);
		add(label);
		add(lblError);
		lblError.getElement().getStyle().setMarginTop(16, Unit.PX);
	}
	
	/**
	 * Creates a material switch with default value.
	 */
	public MaterialSwitch(boolean value) {
		this();
		setValue(value);
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();

		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setValue(!!isEnabled());
				event.preventDefault();
			}
		});
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		span.setEnabled(enabled);
		input.setEnabled(enabled);
	}

	/**
	 * Set the value of switch component.
	 */
	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		boolean oldValue = getValue();
		if(value) {
			input.getElement().setAttribute("checked", "true");
		} else {
			input.getElement().removeAttribute("checked");
		}

		if(fireEvents && oldValue != value) {
			ValueChangeEvent.fire(this, getValue());
		}
	}

	@Override
	public void setValue(Boolean value) {
		setValue(value, true);
	}

	/**
	 * Gets the value of switch component.
	 */
	@Override
	public Boolean getValue() {
		return input.getElement().hasAttribute("checked");
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	/**
	 * @return the input
	 */
	public CustomInput getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(CustomInput input) {
		this.input = input;
	}

	/**
	 * @return the span
	 */
	public CustomSpan getSpan() {
		return span;
	}

	/**
	 * @param span the span to set
	 */
	public void setSpan(CustomSpan span) {
		this.span = span;
	}

	/**
	 * @return the label
	 */
	public CustomLabel getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(CustomLabel label) {
		this.label = label;
	}

	@Override
	public HandlerRegistration addClickHandler(final ClickHandler handler) {
		return addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(isEnabled()) {
					handler.onClick(event);
				}
			}
		}, ClickEvent.getType());
	}

	@Override
	public void setError(String error) {
		errorMixin.setError(error);
	}

	@Override
	public void setSuccess(String success) {
		errorMixin.setSuccess(success);
	}
}
