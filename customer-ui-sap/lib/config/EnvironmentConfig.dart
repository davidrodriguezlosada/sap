class EnvironmentConfig {
  static const String CUSTOMER_SERVICE_SAP_URL_NAME = "customer_service_sap_url";

  static const CUSTOMER_SERVICE_SAP_URL =
      String.fromEnvironment(CUSTOMER_SERVICE_SAP_URL_NAME, defaultValue: "http://192.168.0.126:8080");
}
