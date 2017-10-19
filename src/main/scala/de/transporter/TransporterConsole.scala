package de.transporter

import akka.http.scaladsl.server.Route
import com.lonelyplanet.prometheus.PrometheusResponseTimeRecorder
import com.lonelyplanet.prometheus.api.MetricsEndpoint
import io.prometheus.client.CollectorRegistry

object TransporterConsole {
  val prometheusRegistry: CollectorRegistry = PrometheusResponseTimeRecorder.DefaultRegistry

  val prometheusResponseTimeRecorder: PrometheusResponseTimeRecorder = PrometheusResponseTimeRecorder.Default

  val metricsEndpoint = new MetricsEndpoint(prometheusRegistry)

  val routes: Route = metricsEndpoint.routes
}