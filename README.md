# Instructions for Setup and Configuration

### Generate a Self-Signed Certificate for Development
```bash
# Generate keystore.p12 in your src/main/resources directory
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore src/main/resources/keystore.p12 -validity 3650

# You'll be prompted for:
# - Keystore password (remember this)
# - Your name, organization, etc.
```