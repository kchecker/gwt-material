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

import com.google.gwt.dom.client.Style;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.custom.ComplexWidget;
import gwt.material.design.client.custom.HasIcon;
import gwt.material.design.client.custom.HasImage;

import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

//@formatter:off
/**
 * Chips can be used to represent small blocks of information.
 * They are most commonly used either for contacts or for tags.
 *
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 *{@code// Simple Chips
 * <m:MaterialChip text="Default" icon="close"/>
 *
 * // Static Chip
 * <m:MaterialChip text="Apple" />
 *
 * // Contact Chips
 * <m:MaterialChip url="http://b.vimeocdn.com/ps/339/488/3394886_300.jpg" text="Yunalis Mat Zara'ai" icon="close"/>
 * }
 * </pre>
 * </p>
 *
 * @author kevzlou7979
 * @see <a href="http://gwt-material-demo.herokuapp.com/#chips">Material Chips</a>
 */
//@formatter:on
public class MaterialChip extends ComplexWidget implements HasImage, HasIcon {

	private MaterialIcon icon = new MaterialIcon();

	private ImageResource resource;
	private Image image = new Image();
	
	/**
	 * Creates an empty chip.
	 */
	public MaterialChip() {
		super(Document.get().createDivElement());
		setStyleName("chip");
	}

	public void setText(String text){
		getElement().setInnerText(text);
	}
	
	public String getText(){
		return getElement().getInnerText();
	}

	@Override
	public void setUrl(String url) {
		image.setUrl(url);
		add(image);
	}

	@Override
	public String getUrl() {
		return image.getUrl();
	}

	@Override
	public void setResource(ImageResource resource) {
		this.resource = resource;
		image.setResource(resource);
		add(image);
	}

	@Override
	public ImageResource getResource() {
		return resource;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public MaterialIcon getIcon() {
		return icon;
	}

	@Override
	public void setIconType(IconType iconType) {
		icon.setIconType(iconType);
	}

	@Override
	public void setIconPosition(IconPosition position) {
		icon.setIconPosition(position);
	}

	@Override
	public void setIconSize(IconSize size) {
		icon.setIconSize(size);
	}

	@Override
	public void setIconFontSize(double size, Style.Unit unit) {
		icon.setIconFontSize(size, unit);
	}

	@Override
	public void setIconColor(String iconColor) {
		icon.setIconColor(iconColor);
	}

	@Override
	public void setIconPrefix(boolean prefix) {
		icon.setIconPrefix(prefix);
	}

	@Override
	public boolean isIconPrefix() {
		return icon.isIconPrefix();
	}
}
