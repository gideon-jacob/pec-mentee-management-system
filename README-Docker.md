# Docker Setup for Mentee Management System

This document explains how to run the Spring Boot backend application using Docker Compose.

## Prerequisites

- Docker
- Docker Compose

## Development Setup

### 1. Start the Development Environment

```bash
# Build and start the backend service
docker-compose up --build

# Or run in detached mode
docker-compose up -d --build
```

### 2. Access the Application

- **Main Application**: http://localhost:8080
- **API Endpoints**: 
  - http://localhost:8080/api/
  - http://localhost:8080/api/hello
- **Health Check**: http://localhost:8080/actuator/health

### 3. Development Features

- **Hot Reload**: Source code changes are automatically reflected
- **Maven Cache**: Dependencies are cached for faster builds
- **Health Checks**: Automatic health monitoring

### 4. View Logs

```bash
# View all logs
docker-compose logs

# View backend logs only
docker-compose logs backend

# Follow logs in real-time
docker-compose logs -f backend
```

### 5. Stop the Development Environment

```bash
# Stop and remove containers
docker-compose down

# Stop and remove containers + volumes
docker-compose down -v
```

## Production Setup

### 1. Start the Production Environment

```bash
# Build and start the production service
docker-compose -f docker-compose.prod.yml up --build

# Or run in detached mode
docker-compose -f docker-compose.prod.yml up -d --build
```

### 2. Production Features

- **Optimized JAR**: Pre-built JAR file for better performance
- **Non-root User**: Security best practices
- **Resource Limits**: Optimized JVM settings
- **Health Monitoring**: Built-in health checks

## Troubleshooting

### Common Issues

1. **Port Already in Use**
   ```bash
   # Check what's using port 8080
   lsof -i :8080
   
   # Kill the process or change the port in docker-compose.yml
   ```

2. **Build Failures**
   ```bash
   # Clean and rebuild
   docker-compose down
   docker system prune -f
   docker-compose up --build
   ```

3. **Application Not Starting**
   ```bash
   # Check container logs
   docker-compose logs backend
   
   # Check container status
   docker-compose ps
   ```

### Useful Commands

```bash
# Rebuild without cache
docker-compose build --no-cache

# Execute commands in running container
docker-compose exec backend bash

# View container resources
docker stats

# Clean up unused resources
docker system prune -a
```

## Environment Variables

You can customize the application behavior by setting environment variables:

- `SPRING_PROFILES_ACTIVE`: Set to `docker` for development, `production` for production
- `JAVA_OPTS`: JVM options for memory and garbage collection
- `SERVER_PORT`: Application port (default: 8080)

## Network Configuration

The application runs on a custom Docker network (`mentee-network`) for better isolation and security. 