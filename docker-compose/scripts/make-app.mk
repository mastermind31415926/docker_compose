USER = "$(shell id -u):$(shell id -g)"

app:
	docker-compose up --timeout 60

app-build:
	docker-compose build

app-bash:
	docker-compose run --timeout 60 --user=$(USER) app bash
