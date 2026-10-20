# Grafana Cloud does not ship every catalog plugin by default. Without an
# install, a provisioned data source of that type is invisible in the UI
# ("No data sources found" on dashboard variables).
#
# Infinity (yesoreyeram-infinity-datasource) is pre-provisioned on this Cloud
# stack — installing it via the API returns 409 Conflict. Do not manage it here.
resource "grafana_cloud_plugin_installation" "github" {
  count    = local.enable_github_ci ? 1 : 0
  provider = grafana.cloud

  stack_slug = var.stack_slug
  slug       = "grafana-github-datasource"
  version    = "latest"
}
