USER = "$(shell id -u):$(shell id -g)"

app:
	docker-compose up --abort-on-container-exit

app-build:
	docker-compose build

app-bash:
	docker-compose run --user=$(USER) app bash
