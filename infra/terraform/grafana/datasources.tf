# Infinity → Cloudflare GraphQL (edge traffic + firewall / rate-limit events).
# Official Grafana Cloudflare integration needs Business/Enterprise; Free uses GraphQL instead.
resource "grafana_data_source" "cloudflare_infinity" {
  count    = local.enable_cloudflare_edge ? 1 : 0
  provider = grafana.stack

  # Infinity plugin is pre-provisioned on Grafana Cloud (not managed in plugins.tf).
  type = "yesoreyeram-infinity-datasource"
  name = "Cloudflare GraphQL"
  uid  = "infinity-cloudflare"

  json_data_encoded = jsonencode({
    auth_method = "bearerToken"
    allowedHosts = [
      "https://api.cloudflare.com",
      "https://api.cloudflare.com/client/v4/graphql",
    ]
  })

  secure_json_data_encoded = jsonencode({
    bearerToken = var.cloudflare_analytics_token
  })
}

# GitHub Actions / repo queries (no Alloy exporter).
resource "grafana_data_source" "github" {
  count    = local.enable_github_ci ? 1 : 0
  provider = grafana.stack

  depends_on = [grafana_cloud_plugin_installation.github]

  type = "grafana-github-datasource"
  name = "GitHub Netrunner"
  uid  = "github-netrunner"

  json_data_encoded = jsonencode({
    selectedAuthType = "personal-access-token"
  })

  secure_json_data_encoded = jsonencode({
    accessToken = var.github_access_token
  })
}
