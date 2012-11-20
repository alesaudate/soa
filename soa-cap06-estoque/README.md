Passos:

1) Criar os arquivos certos:
	- WSDL's
	- jaxws-endpoint-config.xml

2) Modificar o serviço
3) Modificar o POM
4) Criar o certificado
	keytool -genkey -keyalg RSA -alias knight_estoque -keystore ../lib/security/cacerts -storepass changeit -validity 360 -keysize 2048
5) Modificar o standalone.xml
6) Modificar o web.xml
