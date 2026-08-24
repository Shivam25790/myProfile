# myProfile

A Spring Boot MVC application (Java 17, Gradle) that stores a simple user profile in an in-memory H2 database.

Run locally
- Generate wrapper if missing: `gradle wrapper` (or use local Gradle)
- Build & run: `./gradlew bootRun` or `gradle bootRun`
- App: http://localhost:8080/profiles
- H2 console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:myprofiledb`)

GitHub Pages and deployment
- GitHub Pages serves static sites only. A Spring Boot app cannot run on GitHub Pages. If you deployed to Pages and saw "The site configured at this address does not contain the requested file", add an `index.html` at the repository root or host the backend on a proper server.
- Options:
  - Host backend on a platform (Render, Railway, Heroku, AWS, GCP) and optionally host a static frontend on GitHub Pages.
  - Add an `index.html` at repo root (already added) so GitHub Pages shows instructions instead of the error.

CI / Production
- To deploy automatically, add a GitHub Actions workflow that builds the app and deploys the artifact to your chosen host.

Notes
- The repo includes starter code: JPA entity, repository, service, controller, Thymeleaf templates, and validation.
