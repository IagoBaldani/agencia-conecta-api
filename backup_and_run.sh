# Verifica se a pasta /backup existe, cria se não existir
if [ ! -d /backup ]; then
  echo "A pasta /backup não existe. Criando agora..."
  mkdir /backup
else
  echo "A pasta /backup já existe."
fi

# Função para gerenciar o número de arquivos de backup
manage_backups() {
  # Contar o número de arquivos .tar na pasta /backup
  local backup_count=$(ls -1 /backup/*.tar 2>/dev/null | wc -l)

  # Se houver mais de 5 arquivos .tar, remove o mais antigo
  if [ "$backup_count" -ge 5 ]; then
    echo "Há $backup_count arquivos de backup. Removendo o mais antigo..."
    oldest_file=$(ls -t /backup/*.tar | tail -n 1)
    rm -f "$oldest_file"
    echo "Arquivo removido: $oldest_file"
  fi
}

# Configura um manipulador de sinal para realizar o backup
trap 'manage_backups && DATE=$(date +%H-%M-%S_%d-%m-%Y) && tar -cvf /backup/mariadb_backup_$DATE.tar /var/lib/mysql' SIGTERM

# Executa o processo principal do MariaDB
/usr/local/bin/docker-entrypoint.sh mariadbd &
PID=$!
wait $PID