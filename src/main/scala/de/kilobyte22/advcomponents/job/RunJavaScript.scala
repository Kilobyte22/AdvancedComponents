package de.kilobyte22.advcomponents.job

import de.kilobyte22.advcomponents.api.jobscheduler.{Job, JobTemplate}

class RunJavaScriptTemplate extends JobTemplate {
  override def getName = "run:javascript"
  override def getUsage = "(script: string) : output: string"
  override def makeJob() = new RunJavaScript
}

class RunJavaScript extends Job {
  override def run() = {

  }
}
