
mkdir -p generated

#Export as html5
docker run --rm \
  -v "$PWD":/documents/ \
  asciidoctor/docker-asciidoctor:latest \
  asciidoctor-revealjs \
  -b revealjs \
  -a revealjsdir=https://cdn.jsdelivr.net/npm/reveal.js \
  unit-tests-course.adoc

#Export as pdf
docker run --name export_to_pdf --rm -v "${PWD}":/documents/ asciidoctor/docker-asciidoctor:latest \
  asciidoctor-pdf unit-tests-course.adoc
