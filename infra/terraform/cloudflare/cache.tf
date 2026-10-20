# Align Cloudflare edge TTL with origin Cache-Control.
# Deploy: HTML max-age=60; versioned JS/CSS max-age=31536000 immutable.
resource "cloudflare_ruleset" "cache" {
  zone_id     = local.zone_id
  name        = "Netrunner cache settings"
  description = "Respect origin Cache-Control for Netrunner hosts."
  kind        = "zone"
  phase       = "http_request_cache_settings"

  rules = [
    {
      ref         = "netrunner_respect_origin"
      description = "Respect origin Cache-Control for Netrunner static assets"
      expression  = "(http.host in {\"netrunner.7oas7er.com\" \"netrunner-stg.7oas7er.com\"})"
      action      = "set_cache_settings"
      action_parameters = {
        cache = true
        edge_ttl = {
          mode = "respect_origin"
        }
        browser_ttl = {
          mode = "respect_origin"
        }
      }
    },
  ]
}
