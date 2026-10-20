locals {
  # Explicit zone id avoids data.cloudflare_zones, whose result embeds deprecated
  # plan/permissions attributes and triggers provider warnings on every plan.
  zone_id = var.zone_id
}

resource "cloudflare_ruleset" "origin_verify" {
  zone_id     = local.zone_id
  name        = "Netrunner origin verify headers"
  description = "Inject X-Origin-Verify so CloudFront accepts only Cloudflare-proxied traffic."
  kind        = "zone"
  phase       = "http_request_late_transform"

  rules = [
    {
      ref         = "stg_origin_verify"
      description = "Staging Netrunner origin verify"
      expression  = "http.host eq \"netrunner-stg.7oas7er.com\""
      action      = "rewrite"
      action_parameters = {
        headers = {
          "X-Origin-Verify" = {
            operation = "set"
            value     = var.stg_origin_verify_secret
          }
        }
      }
    },
    {
      ref         = "prod_origin_verify"
      description = "Production Netrunner origin verify"
      expression  = "http.host eq \"netrunner.7oas7er.com\""
      action      = "rewrite"
      action_parameters = {
        headers = {
          "X-Origin-Verify" = {
            operation = "set"
            value     = var.prod_origin_verify_secret
          }
        }
      }
    },
  ]
}

resource "cloudflare_zone_setting" "ssl" {
  zone_id    = local.zone_id
  setting_id = "ssl"
  value      = "strict"
}
