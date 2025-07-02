#!/bin/bash

echo "Ejecutando OWASP Dependency Check..."

if command -v mvn &> /dev/null; then
    mvn org.owasp:dependency-check-maven:check -DautoUpdate=false -DfailBuildOnCVSS=11
    
    if [ -f "target/dependency-check-report.html" ]; then
        echo "Reporte generado: target/dependency-check-report.html"
    else
        echo "Error: No se pudo generar el reporte"
    fi
else
    echo "Error: Maven no esta instalado"
    exit 1
fi
