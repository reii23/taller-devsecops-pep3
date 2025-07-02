# Taller de Devsecops - PEP 3

Pipeline de integración continua con herramientas de seguridad automatizadas.

| Herramienta | Propósito | Estado |
|-------------|-----------|---------|
| **OWASP Dependency Check** | Análisis de vulnerabilidades en dependencias | Implementado |
| **GitLeaks** | Detección de secretos en código | Implementado |
| **SonarQube** | Análisis estático de calidad de código | Implementado |


## 🚀 Pipeline Actual

```
Build → Test → OWASP Check → Static Analysis → GitLeaks → Deploy
```

### Etapas del Pipeline:
1. **Build**: Compilación con Maven
2. **Test**: Pruebas unitarias
3. **OWASP Dependency Check**: Escaneo de vulnerabilidades
4. **Static Analysis**: SonarQube
5. **GitLeaks Secret Scan**: Detección de secretos
6. **Deploy**: Construcción de imagen Docker

## 📋 Configuración Actual

### Jenkins
- **Tools**: Maven (`mvn`), JDK (`jdk21`)
- **SonarQube**: Servidor configurado en `http://172.17.0.1:9000`
- **Pipeline**: Jenkinsfile en `devsecops-prestabanco-backend/`

## 📊 Monitoreo y Reportes

### Acceso a Reportes
- **Jenkins**: Build Artifacts
- **SonarQube**: `http://IP_VM:9000`