package com.knight.estoque.modelos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "formato")
public enum FormatoArquivo {

	@XmlEnumValue("pdf")
	PDF,

	@XmlEnumValue("mobi")
	MOBI,

	@XmlEnumValue("epub")
	EPUB;

}
