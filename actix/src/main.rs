use actix_web::{web, App, HttpServer, Responder};

fn index(info: web::Path<()>) -> impl Responder {
    format!("Hello World!")
}

fn main() -> std::io::Result<()> {
    HttpServer::new(
        || App::new().service(
              web::resource("/").to(index)))
        .bind("127.0.0.1:8080")?
        .run()
}