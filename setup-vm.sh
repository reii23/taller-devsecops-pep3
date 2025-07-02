
echo "Configurando Docker-in-Docker para Jenkins..."

echo "Verificando Docker daemon..."
if ! systemctl is-active --quiet docker; then
    echo "Iniciando Docker..."
    sudo systemctl start docker
    sudo systemctl enable docker
fi

echo "Configurando permisos del socket Docker..."
sudo chmod 666 /var/run/docker.sock

echo "Deteniendo contenedores actuales..."
docker compose down 2>/dev/null || true

echo "Levantando Jenkins, SonarQube, Backend y PostgreSQL..."
docker compose up -d jenkins sonarqube backend postgres

echo "Esperando a que Jenkins este listo..."
sleep 30

echo "Esperando a que el backend este listo..."
sleep 15

echo "Instalando Docker CLI en Jenkins..."
docker exec jenkins bash -c "apt-get update && apt-get install -y docker.io" 2>/dev/null

echo "Verificando configuracion..."
if docker exec jenkins docker --version; then
    echo ""
    echo "Docker-in-Docker configurado correctamente"
    echo "Acceso Jenkins: http://$(hostname -I | awk '{print $1}'):8082"
    echo "Acceso Backend: http://$(hostname -I | awk '{print $1}'):8080"
    echo "Acceso SonarQube: http://$(hostname -I | awk '{print $1}'):9000"
    echo "Contrasena Jenkins: docker logs jenkins"
    echo ""
    echo "Verificando backend..."
    if curl -s http://localhost:8080/actuator/health > /dev/null 2>&1; then
        echo "Backend corriendo correctamente - OWASP ZAP podra ejecutar analisis DAST"
    else
        echo "Backend aun iniciando - esperar unos minutos para OWASP ZAP"
    fi
else
    echo "Error en la configuracion. Revisar: docker logs jenkins"
fi
