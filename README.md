# Taller de Devsecops - PEP 3

Pipeline de integración continua con herramientas de seguridad automatizadas.

| Herramienta | Propósito | Estado |
|-------------|-----------|---------|
| **OWASP Dependency Check** | Análisis de vulnerabilidades en dependencias | Implementado |
| **GitLeaks** | Detección de secretos en código | Implementado |
| **SonarQube** | Análisis estático de calidad de código | Implementado |
| **OWASP ZAP** | Análisis dinámico | Implementado |


```
Build → Test → OWASP Check → Static Analysis → GitLeaks → OWASP ZAP Security Scan →  Deploy 
```

### Etapas del Pipeline:
1. **Build**: Compilación con Maven
2. **Test**: Pruebas unitarias
3. **OWASP Dependency Check**: Escaneo de vulnerabilidades
4. **Static Analysis**: SonarQube
5. **GitLeaks Secret Scan**: Detección de secretos
6. **OWASP ZAP Security Scan**: Análisis de Dinámico
7. **Deploy**: Construcción de imagen Docker

### URLs de Acceso
- **Jenkins**: `http://<ip>:8082`
- **SonarQube**: `http://<ip>:9000`
- **Backend**: `http://<ip>:8090`

## 📊 Monitoreo y Reportes

### Acceso a Reportes
- **Jenkins**: `http://<ip>:8082` - Build Artifacts y pipeline logs
- **SonarQube**: `http://<ip>:9000` - Análisis de calidad de código
- **Dependency Check**: Reportes en Jenkins artifacts
- **GitLeaks**: Reportes en Jenkins artifacts  
- **OWASP ZAP**: Reportes en Jenkins artifacts

### 1. Iniciar Servicios
```bash
cd ~/taller-devsecops-pep3
docker-compose up -d
```

### 2. Verificar Estado
```bash
docker ps
```

### 3. Acceder a los Servicios
- **Jenkins**: Abrir `http://<ip>:8082` 
- **SonarQube**: Abrir `http://<ip>:9000`
- **Backend**: Verificar con `curl http://<ip>:8090/health`

### 4. Ejecutar Pipeline
1. Ir a Jenkins → `devsecops-prestabanco-pipeline`
2. Hacer clic en "Build Now"
3. Revisar los logs en tiempo real
