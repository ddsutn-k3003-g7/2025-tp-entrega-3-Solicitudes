# 2025-tp-template
Template para TP UTN-DDS Sábados 

ENDPOINTS
GET /solicitudes?hecho={hechoId} → Devuelve las solicitudes asociadas a un hecho
GET /solicitudes/hecho/{hechoId}/activo → Devuelve un hecho y si tiene al menos una solicitud ACEPTADA
GET /solicitudes/{id} → Devuelve una solicitud por su id