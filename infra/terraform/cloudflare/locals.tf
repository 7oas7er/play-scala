locals {
  # Explicit zone id avoids data.cloudflare_zones, whose result embeds deprecated
  # plan/permissions attributes and triggers provider warnings on every plan.
  zone_id = var.zone_id
}
