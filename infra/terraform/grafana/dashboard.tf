resource "grafana_folder" "netrunner" {
  provider = grafana.stack

  title = "Netrunner"
}

locals {
  netrunner_dashboard = merge(
    jsondecode(file("${path.module}/dashboards/netrunner.json")),
    { id = null },
  )

  # Inject Cloudflare zoneTag default when known (dashboard textbox variable).
  netrunner_dashboard_with_zone = var.cloudflare_zone_tag == null ? local.netrunner_dashboard : merge(
    local.netrunner_dashboard,
    {
      templating = {
        list = [
          for v in local.netrunner_dashboard.templating.list : (
            v.name == "cf_zone" ? merge(v, {
              query   = var.cloudflare_zone_tag
              current = { text = var.cloudflare_zone_tag, value = var.cloudflare_zone_tag }
            }) : v
          )
        ]
      }
    },
  )
}

resource "grafana_dashboard" "netrunner" {
  provider = grafana.stack

  folder      = grafana_folder.netrunner.uid
  config_json = jsonencode(local.netrunner_dashboard_with_zone)
  overwrite   = true
}
